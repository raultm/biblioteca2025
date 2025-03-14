package es.acaex.biblioteca.services.copias;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import es.acaex.biblioteca.models.Copy;
import es.acaex.biblioteca.models.Member;
import es.acaex.biblioteca.repositories.CopiesRepository;
import es.acaex.biblioteca.repositories.LoansRepository;
import es.acaex.biblioteca.repositories.MembersRepository;

@Service
public class ReservarCopiarPrestadaService {

    @Autowired
    CopiesRepository copiesRepository;
    @Autowired
    MembersRepository membersRepository;
    @Autowired
    LoansRepository loansRepository;

    public ResponseEntity<Object> execute(Long itemId, Long copyId, Long memberId) {

        if (!copiaEnPrestamoActivo(copyId)) {
            return ResponseEntity.badRequest().body("Esa Copia no está prestada en este momento.");
        }

        if (socioTiene5OMasPrestamosActivos(memberId)) {
            return ResponseEntity.badRequest().body("Esa Socio ya tiene 5 o más préstamos activos.");
        }

        Member socioQueReserva = membersRepository.findById(memberId).orElseThrow();
        Copy copiaAReservar = copiesRepository.findById(copyId).orElseThrow();

        copiaAReservar.setReservedBy(socioQueReserva.getNombreusuario());

        return ResponseEntity.ok(copiesRepository.save(copiaAReservar));
    }

    private boolean copiaEnPrestamoActivo(Long copyId) {
        return loansRepository.existsByReturnedAtIsNullAndCopyId(copyId);
    }

    private boolean socioTiene5OMasPrestamosActivos(Long memberId) {
        return loansRepository.countByReturnedAtIsNullAndMemberId(memberId) >= 5;

    }

}
