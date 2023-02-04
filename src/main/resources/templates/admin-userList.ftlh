<#import "parts/common.ftlh" as c>

<@c.page>
List of users
<table>
    <thread>
        <tr>
            <th>Name</th>
            <th>Role</th>
        </tr>
    </thread>
    <tbody>
    <#list listUsers as user>
        <tr>
            <td>${user.firstName}</td>
            <td>${user.role}</td>
            <td><a href="/api/v1/admin/${user.id}">edit</a></td>
        </tr>
    </#list>
    </tbody>
</table>
</@c.page>
