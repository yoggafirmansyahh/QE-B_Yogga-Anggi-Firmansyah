Feature: Update Data by ID
  As a user
  I want to update data by ID
  So that I can modify existing data

  // TestCase Positif dan Negatif

  Scenario: Mendapatkan daftar user dari endpoint Posts
    Given user memiliki akses ke API JSONPlaceholder untuk Update Data
    When user melakukan request PUT untuk Update Data
    Then user menerima respons dengan kode status 200 untuk Update Data
    And update berhasil

  Scenario: Mendapatkan detail user dari endpoint Posts yang tidak ada
    Given user memiliki akses ke API JSONPlaceholder untuk Update Data secara invalid
    When user melakukan request PUT untuk Update Data secara invalid
    Then user harus menerima respons dengan kode status 404 untuk Update Data
    And data gagal diupdate dan akan mendapat error message