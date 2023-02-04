<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
<div>
    <@l.logout />
</div><br>

    <#list allPosts as el>
        <div>
            <b>${el.id}</b>
            <b>${el.title}</b>
            <span>${el.anons}</span>
            <i>${el.tag}</i>
        </div>
        <#else>
            Blog is empty
    </#list>
</@c.page>