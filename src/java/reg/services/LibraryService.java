/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reg.services;

import reg.dao.GeneralDao;
import reg.domain.Book;
import reg.domain.Librarian;
import reg.domain.LoginStatus;

/**
 *
 * @author duncan
 */
public class LibraryService {
   private GeneralDao<Book> bookDao = new GeneralDao<>(Book.class);
   private GeneralDao<Librarian> librarianDao = new GeneralDao<>(Librarian.class);
   
   public Librarian librarianLogin(String username, String password){
      Librarian lib = librarianDao.findByName(username);
      if(lib == null){
          throw new RuntimeException("Get your things together");
      }
      if(!lib.getPassword().equals(password)){
          throw new RuntimeException("Sinzi aho uri kujya kbsa");
      }
      lib.setLoginStatus(LoginStatus.LOGGED_IN);
      return librarianDao.save(lib);
   }
}
