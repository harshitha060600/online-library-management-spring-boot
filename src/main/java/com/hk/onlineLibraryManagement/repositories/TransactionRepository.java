package com.hk.onlineLibraryManagement.repositories;

import com.hk.onlineLibraryManagement.models.Book;
import com.hk.onlineLibraryManagement.models.Student;
import com.hk.onlineLibraryManagement.models.Transaction;
import com.hk.onlineLibraryManagement.models.TransactionType;
import com.hk.onlineLibraryManagement.models.TransactionStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository {
    Transaction findTopByBookAndStudentAndTransactionTypeAndTransactionStatusOrderByIdDesc(
            Book book, Student student, TransactionType transactionType, TransactionStatus transactionStatus
    );
}
