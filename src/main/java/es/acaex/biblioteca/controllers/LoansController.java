package es.acaex.biblioteca.controllers;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.acaex.biblioteca.dtos.LoanCreate;
import es.acaex.biblioteca.models.Loan;
import es.acaex.biblioteca.repositories.CopiesRepository;
import es.acaex.biblioteca.repositories.LoansRepository;

@RestController
@RequestMapping("loans")
public class LoansController {

    @Autowired
    LoansRepository repository;
    @Autowired
    CopiesRepository copiesRepository;

    @GetMapping
    public List<Loan> listarPrestamos() {
        return repository.findAll();
    }

    @PostMapping
    public Loan prestarCopia(LoanCreate loanCreate) {
        return repository.save(
                Loan.builder()
                        .copyId(loanCreate.getCopyId())
                        .memberId(loanCreate.getMemberId())
                        .startedAt(new Date())
                        .expiredAt(addDays(new Date(), 21))
                        .build());
    }

    @PutMapping("/{id}/return")
    public ResponseEntity<String> terminarPrestamo(@PathVariable Long id) {
        Optional<Loan> optionalLoan = repository.findById(id);
        if (optionalLoan.isPresent()) {
            Loan loan = optionalLoan.get();
            // Verificar si el préstamo ya ha sido devuelto
            if (loan.getReturnedAt() != null) {
                return ResponseEntity.badRequest().body("El préstamo ya ha sido devuelto anteriormente.");
            }
            // Actualizar la fecha de devolución y guardar el préstamo
            loan.setReturnedAt(new Date());
            repository.save(loan);
            return ResponseEntity.ok("Préstamo terminado exitosamente.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}/renovar")
    public ResponseEntity<String> renovarPrestamo(@PathVariable Long id) {
        Optional<Loan> optionalLoan = repository.findById(id);
        if (optionalLoan.isPresent()) {
            Loan loan = optionalLoan.get();
            loan.setExpiredAt(addDays(loan.getExpiredAt(), 15));
            repository.save(loan);
            return ResponseEntity.ok("Préstamo renovado exitosamente.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public static Date addDays(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); // minus number would decrement the days
        return cal.getTime();
    }
}
