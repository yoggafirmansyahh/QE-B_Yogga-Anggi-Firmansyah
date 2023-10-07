Feature: Update Data by ID
  As a user
  I want to update data by ID
  So that I can modify existing data

  // TestCase Positif dan Negatif

  Scenario: Mendapatkan daftar user dari endpoint Posts
    Given user memiliki akses ke API JSONPlaceholder
    When user melakukan request GET ke posts
    Then user harus menerima respons dengan kode status 200
    And respons harus berisi daftar postingan user

  Scenario: Mendapatkan detail user dari endpoint Posts yang tidak ada
    Given user memiliki akses ke API JSONPlaceholder
    When user melakukan permintaan GET ke "/posts/999999" # ID yang tidak valid
    Then user harus menerima respons dengan kode status 404