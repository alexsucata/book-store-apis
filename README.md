# Spring boot API skeleton

## This repo contains a spring boot api skeleton used to expose rest APIs for a book store.
### How to get started

1. Click the green `Use this template` button 
2. Give the repository a name and make sure it is public
3. Click the green `Create repository from template` button

:tada: That should be all. You should have now your own copy of this repository where you can start working
### To keep the project size as small and easy to start as possible we are using
```
private final static Map<String, BookStoreModel> bookStores = FakerUtil.initBookStores();
```
in `BookStoreRepository` to mimic the database. The `HashMap` stores entries of `<(String)id, (BookStoreModel) bookStore>` 

### Expectations:
Using this skeleton as a starting point you need to extend it and expose multiple endpoints useful for interacting with a book store back office.

At a minimum the following APIs should be exposed:

- Book stores:
  - Get all book stores
  - Get a book store by id
  - Add a new book store
- Books:
  - Get all books in a store
  - Get single book in a store by book isbn
  - Add a new book in a store