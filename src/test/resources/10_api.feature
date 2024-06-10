@api
Feature: Test Automation Rest API

  @apiGetUser
  Scenario: Test get list data user
    Given url for "GET_LIST_USERS"
    When hit api to get list users
    Then validation status code is equals 200
    Then validation response body get list users
    Then validation response json with JSONSchema "get_list_users.json"

  @apiGetUser
  Scenario: Test get list data user by id
    Given url for get list user by id "60d0fe4f5311236168a109ca"
    When hit api to get list users
    Then validation status code is equals 200
    Then validation response body get list users by id
    Then validation response json with JSONSchema "get_list_users_by_id.json"

  @apiCreateUser
  Scenario: Test create new user
    Given url for "CREATE_NEW_USERS"
    When hit api to create new users
    Then validation status code is equals 200
    Then validation response body create new users
    Then validation response json with JSONSchema "post_new_users.json"

  @apiCreateUser
  Scenario: Test create new user without First Name
    Given url for "CREATE_NEW_USERS"
    When hit api to create new users without first name
    Then validation status code is equals 400
    Then validation response json with JSONSchema "post_new_users_without_first_name.json"

  @apiCreateUser
  Scenario: Test create new user without email
    Given url for "CREATE_NEW_USERS"
    When hit api to create new users without email
    Then validation status code is equals 400
    Then validation response json with JSONSchema "post_new_users_without_email.json"

  @apiUpdateUser
  Scenario: Test update user
    Given url for "CREATE_NEW_USERS"
    And hit api to create new users
    And validation status code is equals 200
    And validation response body create new users
    When hit api to update data users
    Then validation status code is equals 200
    Then validation response body update user


  @apiDeleteUser
  Scenario: Test delete users
    Given url for "CREATE_NEW_USERS"
    And hit api to create new users
    And validation status code is equals 200
    And validation response body create new users
    When hit api to delete users
    Then validation status code is equals 200

  @apiGetListOfTag
  Scenario: Test get list of tag
    Given url for "GET_TAG"
    When hit api to get tag
    Then validation status code is equals 200
    Then validation response json with JSONSchema "get_list_tag.json"