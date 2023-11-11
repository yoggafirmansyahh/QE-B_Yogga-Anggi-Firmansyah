Feature: Delete Data by ID
  As a user
  I want to delete data by ID
  So that I can remove existing data

  // TestCase Positif dan Negatif

  Scenario: Mendapatkan daftar user dari endpoint DELETE
    Given user memiliki akses ke API JSONPlaceholder untuk hapus data
    When user melakukan request DELETE untuk hapus data
    Then user harus menerima respons dengan kode status 204 untuk hapus data


  Scenario: Mendapatkan detail user dari endpoint DELETE yang tidak ada (invalid)
    Given user memiliki akses ke API JSONPlaceholder untuk hapus data dengan invalid
    When user melakukan request DELETE untuk hapus data dengan invalid
    Then user harus menerima respons dengan kode status 404 untuk hapus data
    And user mendapat pesan error untuk delete data
