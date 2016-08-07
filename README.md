# converter-tests
Tests for converter widget

# Описание задания
- Придумать сценарии для тестирования виджета «Конвертер валют» на сайте http://www.sberbank.ru/ru/person
- Автоматизировать из них 3 сценария

Результат выполненного ТЗ:
- Реализовать функциональные (JUnit) тесты сценариев.
- Использовать инструмент Selenium WebDriver
- Каждый тест должен выглядеть в отчете как отдельный тестовый сценарий
- Тест должны быть параметризирован в XML или CSV
- Результатом выполнения должен быть Yandex.Allure отчет
- Проект должен быть оформлен как артефакт Maven
- Исходный код проекта должен быть выложен на github или bitbucket


# Функциональность виджета:
- При загрузке страницы автоматически выбрана конвертация с рублей на доллары
- В нижней части виджета показывается курс первой валюты в единицах второй с точностью до 4 цифр после запятой (при переключении валют он соответствующим образом меняется)
- При попытке выбрать одинаковые валюты - для текущего поля ввода выбирается требуемая валюта, для другого поля ввода выбирается соответствующая валюта по умолчанию (RUR для EUR и USD, USD для RUR)
- При вводе в поле "Поменять" автоматически рассчитывается значение в поле "На" в соответствии с текущим курсом
- При вводе в поле "На" автоматически рассчитывается значение в поле "Поменять" в соответствии с текущим курсом
- При изменении валюты у поля ввода соответствующим образом пересчитывается значение
- Допустимый формат ввода \d+.\d[2] (недопустимые символы игнорируются, при вводе символа запятой в поле записывается символ точки)
- Отображение текущей даты

# Тестовые сценарии
Сценарий 1

Предусловия
Открыта страница http://www.sberbank.ru/ru/person

Шаги
В первом поле выбираем валюту и вводим сумму

Ожидаемый результат
Во втором поле отображается результат конвертации в соответствии с курсом

Сценарий 2

Предусловия
Открыта страница http://www.sberbank.ru/ru/person

Шаги
Во втором поле выбираем валюту и вводим сумму

Ожидаемый результат
В первом поле отображается результат конвертации в соответствии с курсом

Сценарий 3

Предусловия
Открыта страница http://www.sberbank.ru/ru/person

Шаги
1. В первом поле выбираем валюту и вводим сумму
2. В первом поле меняем валюту

Ожидаемый результат
Во втором поле пересчитывается результат конвертации в соответствии с выбранной в первом поле валютой
