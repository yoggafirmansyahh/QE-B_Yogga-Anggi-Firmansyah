Feature: Get User
  As a user
  I want to get single user
  So that I can read single user data

  //TestCasePositifdanNegatif

  Scenario: Mendapatkan daftar user dari endpoint GET
    Given user memiliki akses ke API JSONPlaceholder untuk Get User
    When user melakukan request GET untuk Get User
    Then user harus menerima respons dengan kode status 200 untuk Get User
    And data user berhasil didapatkan

  Scenario: Mendapatkan detail user dari endpoint GET yang tidak ada
    Given user memiliki akses ke API JSONPlaceholder untuk Get User secara invalid
    When user melakukan request GET ke endpoint dengan ID yang tidak valid untuk Get User
    Then user harus menerima respons dengan kode status 404 untuk Get User
    And tidak ada data user yang ditemukan
