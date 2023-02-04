<#import "parts/common.ftlh" as c>

<@c.page>
User editor
<form action="/api/v1/admin" method="post">
  <input type="text" name="firstName" value="${user.firstName}">
  <input type="text" name="role" value="${user.role}">
  <input type="hidden" value="${user.id}" name="id">
  <input type="hidden" value="${_csrf.token}" name="_csrf">
  <button type="submit">Save</button>
</form>
</@c.page>