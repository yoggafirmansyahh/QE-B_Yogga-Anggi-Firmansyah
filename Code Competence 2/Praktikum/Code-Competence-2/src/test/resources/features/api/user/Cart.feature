Feature: Cart
  As a user
  I want to access cart feature
  So that i can access the data on cart feature

  Scenario: User dapat menghapus produk yang ada pada cart
    Given user memiliki akses untuk dapat melakukan penghapusan produk pada cart
    When user send request dengan method DELETE untuk menghapus data
    And user berhasil melakukan delete pada data di dalam cart