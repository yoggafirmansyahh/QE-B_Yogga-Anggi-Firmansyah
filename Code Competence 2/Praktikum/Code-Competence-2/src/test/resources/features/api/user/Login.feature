Feature: Login
  As a user
  I want to login
  So that i can access the dashboard page

Scenario: User dapat login dengan valid
  Given user send request untuk login dengan valid
  When user send request dengan method POST untuk dapat login
  Then muncul status code sesuai untuk login berhasil yaitu 200
  And user telah login dengan valid

Scenario: User login dengan invalid
  Given user send request untuk login dengan endpoint yang salah
  When user send request dengan method POST dengan endpoint yang salah
  Then muncul status code 400 yang menandakan error
  And user gagal login dengan valid dan muncul pesan error
