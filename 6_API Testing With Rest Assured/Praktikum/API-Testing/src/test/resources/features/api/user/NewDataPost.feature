Feature: Get New Data Post
  As a user
  I want to get new new data post
  So that I can make new data post

  //TestCasePositifdanNegatif

  Scenario: Mendapatkan daftar user dari endpoint POSTS
    Given user memiliki akses ke API JSONPlaceholder untuk New Data Post
    When user melakukan request POST untuk New Data Post
    Then user harus menerima respons dengan kode status 201 untuk New Data Post
    And respons berisi data baru

  Scenario: Mendapatkan detail user dari endpoint POSTS yang tidak ada
    Given user memiliki akses ke API JSONPlaceholder untuk New Data Post dengan invalid
    When user melakukan request POST untuk New Data Post dengan invalid
    Then user harus menerima respons dengan kode status 500 untuk New Data Post
    And data post baru gagal dibuat

