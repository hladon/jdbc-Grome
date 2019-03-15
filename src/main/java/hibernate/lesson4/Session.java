package hibernate.lesson4;


import hibernate.lesson4.model.User;

abstract class Session {
    private static User logedUser = null;

    public static User getLogedUser() {
        return logedUser;
    }

    public static void setLogedUser(User logedUser) {
        Session.logedUser = logedUser;
    }
}
