package com.fullstackprojects.recyclingapp.dao;

import com.fullstackprojects.recyclingapp.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


public interface ItemRepository extends JpaRepository<Item, Long> {

    Page<Item> findByTitleContaining(@RequestParam("title") String title, Pageable pageable);

    Page<Item> findByCategory(@RequestParam("category") String category, Pageable pageable);

//    @Query("select o from Item o where id in :item_ids")
//    List<Item> findItemsByItemIds(@Param("item_ids") List<Long> itemId);
}
