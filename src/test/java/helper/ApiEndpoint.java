package helper;

import static page.ApiPage.idUser;

public class ApiEndpoint {
    public static final String host_dummyapi = "https://dummyapi.io/data/v1/";
    public static final String GET_LIST_USER = host_dummyapi + "user";
    public static final String CREATE_NEW_USER = host_dummyapi + "user/"+"create";

    public static final String UPDATE_USER = host_dummyapi + "users/"+ idUser;
    public static final String GET_TAG = host_dummyapi + "tag";


}