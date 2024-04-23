package com.deloitte.onlinebookstore.service;

import com.deloitte.onlinebookstore.model.Book;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ShoppingCartService {

    @Autowired
    HttpSession httpSession;

    @Autowired
    BookService bookService;

    public ShoppingCartService(HttpSession httpSession) {
        this.httpSession = httpSession;
    }
    public HttpSession getSession() {
        return httpSession;
    }
    public List<Book> getCart() {
        List<Book> cart = (List<Book>) httpSession.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }
        return cart;
    }
    public void emptyCart() {
        List<Book> cart = getCart();
        cart.removeAll(cart);
    }

    public void addToCart(Long id) {
        List<Book> cart = getCart();
        Book book = bookService.getBookById(id);
        if(book != null) {
            cart.add(book);
        }
        getSession().setAttribute("cart",cart);
    }

    public void removeFromCart(Long id) {
        List<Book> cart = getCart();
        Book book = bookService.getBookById(id);
        if(book != null) {
            for(Book b: cart) {
                if(Objects.equals(b.getId(), id)) {
                    cart.remove(b);
                    break;
                }
            }
        }
        getSession().setAttribute("cart",cart);
    }

//    @Autowired
//    ShoppingCartRepository shoppingCartRepository;
//
//    public String addToCart(Long userId, Long bookId, int quantity) {
//        User user = userService.getUserById(userId);
//        Book book = bookService.getBookById((bookId));
//        shoppingCartRepository.save();
//    }


}
