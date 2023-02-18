package com.fullstackprojects.recyclingapp.service;

import com.fullstackprojects.recyclingapp.dao.ItemRepository;
import com.fullstackprojects.recyclingapp.dao.VerifyRepository;
import com.fullstackprojects.recyclingapp.dao.HistoryRepository;
import com.fullstackprojects.recyclingapp.entity.Item;
import com.fullstackprojects.recyclingapp.entity.Checkout;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@Service
@Transactional
public class ItemService {

    private ItemRepository itemRepository;

    private VerifyRepository verifyRepository;

    private HistoryRepository historyRepository;

    public ItemService(ItemRepository itemRepository, VerifyRepository verifyRepository,
                       HistoryRepository historyRepository){
        this.itemRepository = itemRepository;
        this.verifyRepository = verifyRepository;
        this.historyRepository = historyRepository;
    }

    public Item checkoutBook(String userEmail, Long itemId) throws Exception {

        Optional<Item> item = itemRepository.findById(itemId);

        Checkout validateCheckout = verifyRepository.findByUserEmailAndBookId(userEmail, itemId);

        if (!item.isPresent() || validateCheckout != null) {
            throw new Exception("Item doesn't exist");
        }

        itemRepository.save(item.get());

        Checkout checkout = new Checkout(
                userEmail,
                LocalDate.now().toString(),
                LocalDate.now().plusDays(7).toString(),
                item.get().getId()
        );

        verifyRepository.save(checkout);
        return item.get();
    }

    public Boolean checkoutBookByUser(String userEmail, Long bookId) {
        Checkout validateCheckout = verifyRepository.findByUserEmailAndBookId(userEmail, bookId);
        if (validateCheckout != null) {
            return true;
        } else {
            return false;
        }
    }

    public int currentLoansCount(String userEmail) {
        return verifyRepository.findBooksByUserEmail(userEmail).size();
    }

//    public List<ShelfCurrentLoansResponse> currentLoans(String userEmail) throws Exception {
//
//        List<ShelfCurrentLoansResponse> shelfCurrentLoansResponses = new ArrayList<>();
//
//        List<Checkout> checkoutList = checkoutRepository.findBooksByUserEmail(userEmail);
//
//        List<Long> bookIdList = new ArrayList<>();
//
//        for (Checkout i : checkoutList) {
//            bookIdList.add(i.getBookId());
//        }
//
//        List<Item> items = itemRepository.findBooksByBookIds(bookIdList);
//
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//
//        for (Item item : items) {
//            Optional<Checkout> checkout = checkoutList.stream()
//                    .filter(x -> x.getBookId() == item.getId()).findFirst();
//
//            if (checkout.isPresent()) {
//
//                Date d1 = sdf.parse(checkout.get().getReturnDate());
//                Date d2 = sdf.parse(LocalDate.now().toString());
//
//                TimeUnit time = TimeUnit.DAYS;
//
//                long difference_In_Time = time.convert(d1.getTime() - d2.getTime(),
//                        TimeUnit.MILLISECONDS);
//
//                shelfCurrentLoansResponses.add(new ShelfCurrentLoansResponse(item, (int) difference_In_Time));
//            }
//        }
//        return shelfCurrentLoansResponses;
//    }

//    public void returnBook (String userEmail, Long itemId) throws Exception {
//
//        Optional<Item> item = itemRepository.findById(itemId);
//
//        Checkout validateCheckout = checkoutRepository.findByUserEmailAndBookId(userEmail, itemId);
//
//        if (!item.isPresent() || validateCheckout == null) {
//            throw new Exception("Book does not exist or not checked out by user");
//        }
//
//        itemRepository.save(item.get());
//        checkoutRepository.deleteById(validateCheckout.getId());
//
//        History history = new History(
//                userEmail,
//                validateCheckout.getCheckoutDate(),
//                LocalDate.now().toString(),
//                item.get().getCategory(),
//                item.get().getTitle(),
//                item.get().getDescription(),
//                item.get().getStatus()
//        );
//
//        historyRepository.save(history);
//    }

//    public void renewLoan(String userEmail, Long bookId) throws Exception {
//
//        Checkout validateCheckout = checkoutRepository.findByUserEmailAndBookId(userEmail, bookId);
//
//        if (validateCheckout == null) {
//            throw new Exception("Book does not exist or not checked out by user");
//        }
//
//        SimpleDateFormat sdFormat = new SimpleDateFormat("yyy-MM-dd");
//
//        Date d1 = sdFormat.parse(validateCheckout.getReturnDate());
//        Date d2 = sdFormat.parse(LocalDate.now().toString());
//
//        if (d1.compareTo(d2) > 0 || d1.compareTo(d2) == 0) {
//            validateCheckout.setReturnDate(LocalDate.now().plusDays(7).toString());
//            checkoutRepository.save(validateCheckout);
//        }
//    }

}
