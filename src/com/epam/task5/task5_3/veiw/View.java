package com.epam.task5.task5_3.veiw;

import java.util.Map;

public interface View<T, S, K, V> {
    void showMenu();
    S getRequestFromUser();
    void showMessage(T message);
}
