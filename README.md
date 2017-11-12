# TextFileThreadChanger

class TextHandler - призначений для роботи з текстовим файлом file.txt, містить методи для зчитування і запису даних
class WorkStarter - призначений для запуску потоку Worker і отримання хеша текстових даних, які були зчитані
В методі run, потока Provider, виконується зчитування даних з файла, отримання хеша цих данних і запис хеша у файл.

В методі main створються об'єкти TextHandler, WorkStarter, Worker, 3 об'єкта Provider i виконуєтсья запуск 
через ExecutorService 3-х потоків.
