<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
Login page
<@l.login "/auth/login" />
<a href="/auth/registration">Add new user</a>

</@c.page>
