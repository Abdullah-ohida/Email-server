package com.Notification;

import com.emailing.Message;
import com.services.Account;

public interface NotificationService {
    Alert createAlert(Account account, Message message);

    void notify(Alert alert);
}
