<a href="https://alfabank.ru/ "> <img src="media/Alfa-Bank.svg" width="350" height="200"> 
<h1 >Проект по автоматизации тестирования для компании <a href="https://alfabank.ru/ "> Альфа-банк</a></h1> 

## ☑️ Содержание:

- [Технологии и инструменты](#технологии-и-инструменты)
- [Реализованные Web проверки](#реализованные-web-проверки)
- [Реализованные mobile Android проверки](#реализованные-mobile-android-проверки)
- [Сборка в Jenkins](#img-altjenkins-height25-srcmediajenkinssvg-width25-сборка-в-jenkins)
- [Параметры сборки в Jenkins](#параметры-сборки-в-jenkins)
- [Команды для запуска тестов](#команда-для-запуска-из-терминала)
- [Allure Report](#allure-report)
- [Allure TestOps](#allure-testops)
- [Уведомление в Telegram](#telegram)
- [Примеры видео выполнения web тестов](#web-video)
- [Примеры видео выполнения мобильных тестов](#browserstack-video-examples)

<a id="tools"></a>

## Технологии и инструменты:

<p align="center">
<a href="https://www.jetbrains.com/idea/"><img width="7%" title="IntelliJ IDEA" src="media/intellij-idea-svgrepo-com.svg">
<a href="https://www.java.com/ru/"> <img width="7%" title="Java" src="media/java-svgrepo-com.svg">
<a href="https://selenide.org/"> <img width="7%" title="Selenide" src="media/Selenide.svg">
<a href="https://aerokube.com/selenoid/"> <img width="7%" title="Selenoid" src="media/Selenoid.svg">
<a href="https://github.com/allure-framework/"> <img width="7%" title="Allure Report" src="media/Allure.svg">
<a href="https://qameta.io/"> <img width="7%" title="Allure TestOps" src="media/Allure_TestOps.svg">
<a href="https://gradle.org/"> <img width="7%" title="Gradle" src="media/gradle-svgrepo-com.svg">
<a href="https://junit.org/"> <img width="7%" title="JUnit5" src="media/Junit5.svg">
<a href="https://github.com/"> <img width="7%" title="GitHub" src="media/github-badge-svgrepo-com.svg">
<a href="https://www.jenkins.io/"> <img width="7%" title="Jenkins" src="media/Jenkins.svg">
<a href="https://telegram.org/"> <img width="7%" title="Telegram" src="media/Telegram.svg">
<a href="https://appium.io/docs/en/latest/"> <img width="7%" title="Appium" src="media/appium.svg">
<a href="https://developer.android.com/studio"> <img width="7%" title="AndroidStudio" src="media/androidstudio.svg">
<a href="https://www.browserstack.com/"> <img width="7%" title="BrowserStack" src="media/Browserstack.svg">
</p>
<a id="cases"></a>

## Реализованные Web проверки:

- Проверка, что при наведении на меню "Частным лицам" открывается меню,
- Проверка наличия пункта "Кредиты" в меню,
- Проверка открытия страницы кредитный калькулятор,
- Проверка открытия страницы входа в личный кабинет,
- Проверка открытия страницы "Войти" и выбираем "Войти в Альфа-онлайн",
- Проверка открытия страницы "Стать клиентом",
- Открываем виджет поиска и проверяем, что нашлось значение qa.guru,
- Проверяем максимальную сумму кредита на странице Кредитный калькулятор,
- Проверяем отображения текста Госуслуги или справка о доходах если сумма кредита больше 300.000,
- Проверяем маску телефона на странице "Войти в Альфа-онлайн".

## Реализованные mobile Android проверки:

- Проверка тайтла на экране входа,
- Проверка, что кнопка зайти задизейблена если поле ввода не заполнено,
- Проверка, что у кнопки входа текст Зайти,
- Проверка ввода некорректного телефона и отображения ошибки,
- Проверка ввода некорректного иностранного телефона и отображения ошибки,
- Проверка ввода корректного номера и успешный вход.

##  <img alt="Jenkins" height="25" src="media/Jenkins.svg" width="25"/> Сборка в [Jenkins](https://jenkins.autotests.cloud/job/ONamozov_diplom_34/)

<p align="center">
<a href="https://jenkins.autotests.cloud/job/ONamozov_diplom_34"> <img title="Jenkins" src="media/JenkinsBuild.png" width="950">  
</p>


## Параметры сборки в Jenkins:

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
-DbrowserRemote="https://login:password@${BROWSER_REMOTE}/wd/hub"
```

## <img alt="Allure" height="25" src="media/Allure.svg" width="25"/></a>  <a name="Allure"></a>Allure Report    </a>
<a id="allure-report"></a>
## Основная страница отчёта

<p align="center">  
<a href="https://jenkins.autotests.cloud/job/ONamozov_diplom_34"> <img title="Allure Overview Dashboard" src="media/AllureReport.png" width="850">  
</p>  

## <img alt="Allure" height="25" src="media/Allure_TestOps.svg" width="25"/></a>  <a name="Allure TestOps"></a>Allure TestOps    </a>
<a id="allure-testops"></a>
## Основная страница отчёта Allure TestOps

<p align="center">  
<a href="https://allure.autotests.cloud/project/4783/launches"> <img title="Allure Overview Dashboard" src="media/AllureTestOpsReport.png" width="850">  
</p>  

## Список тест-кейсов

<p align="center">  
<a href="https://allure.autotests.cloud/project/4783/test-cases?treeId=0"> <img title="Allure Overview Dashboard" src="media/TestCase.png" width="850">  
</p>
<a id="telegram"></a>

## <img alt="Allure" height="25" src="media/Telegram.svg" width="25"/></a> Уведомление в Telegram при помощи бота

____
<p align="center">  
<img title="Allure Overview Dashboard" src="media/tgAllert.jpg" width="550">  
</p>

____
<a id="web-video"></a>
## <img alt="Selenoid" height="25" src="media/Selenoid.svg" width="25"/></a> Примеры видео выполнения web тестов в Selenoid

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

<a id="browserstack-video-examples"></a>
## <img alt="Selenoid" height="25" src="media/Browserstack.svg" width="25"/></a> Примеры видео выполнения мобильных тестов в BrowserStack

____
<p align="center">
<img title="Selenoid Video" src="media/badNumber-.gif" width="350" height="550"  alt="video">   
</p>

<p align="center">
<img title="Selenoid Video" src="media/successfull-.gif" width="350" height="550"  alt="video">   
</p>
