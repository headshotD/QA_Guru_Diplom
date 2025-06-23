
<a href="https://alfabank.ru/ "> <img src="media/Alfa-Bank.svg" width="350" height="200"> 
<h1 >Проект по автоматизации тестирования для компании <a href="https://alfabank.ru/ "> Альфа-банк</a></h1> 

## ☑️ Содержание:

- Технологии и инструменты
- Список проверок, реализованных в тестах
- Запуск тестов в Jenkins и из терминала
- Allure-отчет
- Уведомление в Telegram о результатах прогона тестов
- Видео пример прохождения тестов

<a id="tools"></a>
## :ballot_box_with_check:Технологии и инструменты:

|         Java                                                                                                      | IntelliJ  <br>  Idea                                                                                               | GitHub                                                                                                     | JUnit 5                                                                                                           | Gradle                                                                                                     | Selenide                                                                                                         | Selenoid                                                                                                                  | Allure <br> Report                                                                                                         |  Jenkins                                                                                                        |   Telegram
|:----------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------|
| <a href="https://www.java.com/"><img src="media/java-svgrepo-com.svg" width="50" height="50"  alt="Java"/></a>  | <a href="https://www.jetbrains.com/idea/"><img src="media/intellij-idea-svgrepo-com.svg" width="50" height="50"  alt="IDEA"/></a> | <a href="https://github.com/"><img src="media/github-badge-svgrepo-com.svg" width="50" height="50"  alt="Github"/></a> | <a href="https://junit.org/junit5/"><img src="media/Junit5.svg" width="50" height="50"  alt="JUnit 5"/></a> | <a href="https://gradle.org/"><img src="media/gradle-svgrepo-com.svg" width="50" height="50"  alt="Gradle"/></a> | <a href="https://selenide.org/"><img src="media/Selenide.svg" width="50" height="50"  alt="Selenide"/></a> | <a href="https://aerokube.com/selenoid/"><img src="media/Selenoid.svg" width="50" height="50"  alt="Selenoid"/></a> | <a href="https://github.com/allure-framework"><img src="media/Allure.svg" width="50" height="50"  alt="Allure"/></a> |<a href="https://www.jenkins.io/"><img src="media/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a> | <a href="https://web.telegram.org/"><img src="media/Telegram.svg" width="50" height="50" alt="Telegram"/></a> |<a href="https://qameta.io/"><img src="images\logo\Allure_TO.svg" width="50" height="50" alt="Allure_TO"/></a> |

<a id="cases"></a>
## :ballot_box_with_check: Реализованные Web проверки:

- Проверка, что при наведении на меню "Частным лицам" открывается меню,
- Проверка наличия пункта "Кредиты" в меню",
- Проверка открытия страницы кредитный калькулятор,
- Проверка открытия страницы входа в личный кабинет,
- Проверка открытия страницы "Войти" и выбираем "Войти в Альфа-онлайн"
- Проверка открытия страницы "Стать клиентом",
- Открываем виджет поиска и проверяем, что нашлось значение qa.guru.

## :ballot_box_with_check: Реализованные mobile Android проверки:

- Проверка тайтла на экране входа,
- Проверка, что кнопка зайти задизейблена если поле ввода не заполнено
- Проверка, что у кнопки входа текст Зайти
- Проверка ввода некорректного телефона и отображения ошибки
- Проверка ввода некорректного иностранного телефона и отображения ошибки
- Проверка ввода корректного номера и успешный вход

## <img alt="Jenkins" height="25" src="media/Jenkins.svg" width="25"/> Сборка в [Jenkins](https://jenkins.autotests.cloud/job/ONamozov_diplom_34/)


<p align="center">  
<img src="media/JenkinsBuild.png" alt="Jenkins" width="950"/></a>  
</p>


## :ballot_box_with_check: Параметры сборки в Jenkins:
- Tag (Уникальный тэг тестов)
- browser (браузер, по умолчанию chrome)
- browserVersion (версия браузера, по умолчанию 127.0)
- browserSize (размер окна браузера, по умолчанию 1920x1080)


## Команда для запуска из терминала
Локальный запуск mobile Android тестов
```bash
gradle clean AlfaBankAndroidEmulation
```
Удаленный запуск mobile Android тестов
```bash
gradle clean android_browserstack
```
Локальный запуск для запуска Web тестов
```bash
gradle clean AlfaBankWeb
```
Локальный запуск всех тестов
```bash
gradle clean AllTests
```
Запуск с параметрами Web тестов:
```bash  
gradle clean AlfaBankWeb -Dbrowser=chrome -DbrowserSize=1920x1080 -DbrowserVersion=128.0
```
Удаленный запуск через Jenkins:
```bash  
clean
"${TAG}"
-Dbrowser="${BROWSER}"
-DbrowserSize="${BROWSER_SIZE}"
-DbrowserVersion="${BROWSER_VERSION}"
-DbrowserRemote="https://user1:1234@${BROWSER_REMOTE}/wd/hub"
```

## <img alt="Allure" height="25" src="media/Allure.svg" width="25"/></a>  <a name="Allure"></a>Allure Report	</a>


## Основная страница отчёта

<p align="center">  
<img title="Allure Overview Dashboard" src="media/AllureReport.png" width="850">  
</p>  

____
## <img alt="Allure" height="25" src="media/Telegram.svg" width="25"/></a> Уведомление в Telegram при помощи бота
____
<p align="center">  
<img title="Allure Overview Dashboard" src="media/tgAllert.jpg" width="550">  
</p>

____
## <img alt="Selenoid" height="25" src="media/Selenoid.svg" width="25"/></a> Примеры видео выполнения тестов на Selenoid
____
<p align="center">
<img title="Selenoid Video" src="media/openEnterPage.gif" width="550" height="350"  alt="video">   
</p>

<p align="center">
<img title="Selenoid Video" src="media/search.gif" width="550" height="350"  alt="video">   
</p>

<p align="center">
<img title="Selenoid Video" src="media/hoverAndCredit.gif" width="550" height="350"  alt="video">   
</p>

<p align="center">
<img title="Selenoid Video" src="media/badNumber-.gif" width="350" height="550"  alt="video">   
</p>

<p align="center">
<img title="Selenoid Video" src="media/successfull-.gif" width="350" height="550"  alt="video">   
</p>