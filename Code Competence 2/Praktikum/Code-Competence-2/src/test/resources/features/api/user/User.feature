Feature: User
  As a user
  I want to access user feature
  So that i can access the data and user feature

  Scenario: User dapat mendapat satu data user
    Given user akses endpoint untuk mendapatkan data user
    When user send request untuk mendapatkan satu data user
    Then data salah satu user dapat dilihat

  Scenario: User menghapus data user
    Given user akses endpoint untuk menghapus data user
    When user send request dengan method DELETE untuk menghapus data pada database
    Then muncul status code sesuai yaitu 200 setelah mencoba menghapus data user
