package com.example.bootex2.repository;

import com.example.bootex2.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Memorepository extends JpaRepository<Memo, Long> {
}
