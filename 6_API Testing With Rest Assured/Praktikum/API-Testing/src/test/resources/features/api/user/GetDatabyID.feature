Feature: Get User by ID
  As a user
  I want to get single user
  So that I can read single user data

  // TestCase Positif dan Negatif

  Scenario: Mendapatkan daftar user dari endpoint POSTS
    Given user memiliki akses ke API JSONPlaceholder untuk Get Data by ID
    When user melakukan request GET ke posts untuk Get Data by ID
    Then user harus menerima respons dengan kode status 200 untuk Get Data by ID
    And respons harus berisi daftar postingan user sesuai ID

  Scenario: Mendapatkan detail user dari endpoint POSTS yang tidak ada
    Given user memiliki akses ke API JSONPlaceholder untuk Get Data by ID secara invalid
    When user melakukan request GET ke posts untuk Get Data by ID secara invalid
    Then user harus menerima respons dengan kode status 404 untuk Get Data by ID
    And user akan menerima pesan error untuk data id yang tidak muncul