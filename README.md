# Лабораторная работа 2: Реализация `MultiValueMap`

## Описание

В данной лабораторной работе реализована структура данных `MultiValueMap`, которая позволяет хранить несколько значений для каждого ключа. Это расширение стандартного интерфейса `Map<K, V>` предоставляет дополнительные возможности для управления коллекциями значений, ассоциированных с одним ключом.

## Ключевые особенности `MultiValueMap`

- **Хранение нескольких значений**: Позволяет ассоциировать один ключ с коллекцией значений.
- **Реализация интерфейса `Map<K, Collection<V>>`**: Обеспечивает совместимость с существующими API Java Collections.
- **Итерация по значениям**: Реализован `Iterable<V>`, что позволяет перебор всех значений независимо от ключей.


- **`src/main/java/com/project/MultiValueMap.java`** — Реализация класса `MultiValueMap`.
- **`src/main/java/com/project/Main.java`** — Точка входа приложения для демонстрации работы `MultiValueMap`.
- **`src/test/java/com/project/MultiValueMapTest.java`** — Модульные тесты для `MultiValueMap` с использованием JUnit.
- **`pom.xml`** — Конфигурационный файл Maven для управления зависимостями и сборкой проекта.

## Тестирование

Особое внимание уделено модульным тестам, которые покрывают основные функциональные возможности `MultiValueMap`:

- **Добавление и получение значений**: Проверяется корректность добавления нескольких значений к одному ключу и их последующее получение.
- **Проверка наличия ключей и значений**: Убедиться, что методы `containsKey` и `containsValue` работают правильно.
- **Удаление значений**: Тестируется удаление значений по ключу и проверяется размер словаря после удаления.
- **Итерация**: Проверяется корректность итерации по всем значениям в словаре.
- **Метод `putAll`**: Тестируется добавление всех элементов из другого словаря.
