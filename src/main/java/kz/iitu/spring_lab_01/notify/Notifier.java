package kz.iitu.spring_lab_01.notify;

public interface Notifier {

    String send(String message);   // возвращает отправленное сообщение

    String channel();              // имя канала для отчёта
}