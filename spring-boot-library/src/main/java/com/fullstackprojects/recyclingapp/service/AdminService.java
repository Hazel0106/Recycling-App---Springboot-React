package com.fullstackprojects.recyclingapp.service;

import com.fullstackprojects.recyclingapp.dao.ItemRepository;
import com.fullstackprojects.recyclingapp.dao.VerifyRepository;
import com.fullstackprojects.recyclingapp.dao.ReviewRepository;
import com.fullstackprojects.recyclingapp.entity.Item;
import com.fullstackprojects.recyclingapp.requestmodels.AddItemRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class AdminService {

    private ItemRepository itemRepository;
    private ReviewRepository reviewRepository;
    private VerifyRepository verifyRepository;

    @Autowired
    public AdminService(ItemRepository itemRepository,
                        ReviewRepository reviewRepository,
                        VerifyRepository verifyRepository) {

        this.itemRepository = itemRepository;
        this.reviewRepository = reviewRepository;
        this.verifyRepository = verifyRepository;
    }

//    public void increaseBookQuantity(Long bookId) throws Exception {
//
//        Optional<Item> item = itemRepository.findById(bookId);
//
//        if (!item.isPresent()) {
//            throw new Exception("Item not found");
//        }
//
//        itemRepository.save(item.get());
//    }
//
//    public void decreaseBookQuantity(Long itemId) throws Exception {
//
//        Optional<Item> item = itemRepository.findById(itemId);
//
//        if (!item.isPresent()) {
//            throw new Exception("Item not found");
//        }
//
//        itemRepository.save(item.get());
//    }

    public void postItem(AddItemRequest addItemRequest) {
        Item item = new Item();
        item.setTitle(addItemRequest.getTitle());
        item.setDescription(addItemRequest.getDescription());
        item.setCategory(addItemRequest.getCategory());
        item.setStatus(addItemRequest.getStatus());
        itemRepository.save(item);
    }

    public void deleteItem(Long itemId) throws Exception {

        Optional<Item> item = itemRepository.findById(itemId);

        if (!item.isPresent()) {
            throw new Exception("Item not found");
        }

        itemRepository.delete(item.get());
        reviewRepository.deleteAllByBookId(itemId);
        verifyRepository.deleteAllByBookId(itemId);
    }
}
