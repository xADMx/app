<#macro page>
<!DOCTYPE html>
<html>
    <Head>
        <Title></Title>
    </Head>
    <Body>
    <a href="/school/add"> Добавить школу </a><br>
    <a href="/school/"> Список школ </a><br>
        <a href="/student/add"> Добавить ученика </a><br>
        <a href="/student/"> Список учеников </a><br>
        <a href="/student/rating/"> Рейтинг </a><br>
        <a href="/start/test/"> Добавить тестовые данные </a><br>
        <a href="/log/"> ЛОГ </a><br>
        <#nested>
    </Body>
</Html>
</#macro>