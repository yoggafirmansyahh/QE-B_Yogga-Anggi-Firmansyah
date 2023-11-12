Feature: Product
  As a user
  I want to access product feature
  So that i can access the data on product feature

  Scenario: User dapat mengambil semua informasi produk
    Given user akses endpoint untuk mengakses informasi produk dengan valid
    When user send request dengan endpoint yang valid untuk mengakses informasi produk
    Then muncul status code sesuai untuk menampilkan semua informasi produk
    And semua informasi produk berhasil ditampikan

  Scenario: User dapat menghapus informasi produk
    Given user akses endpoint untuk dapat melakukan penghapusan produk pada database
    When user send request dengan method DELETE untuk menghapus data dengan endpoint yang benar
    Then muncul status code sesuai setelah menghapus data informasi produk
