<#macro registration path>
<form action="#{path}" method="post">
    <div><label> Email : <input type="text" name="email"/> </label></div>
    <div><label> First Name : <input type="text" name="firstName"/> </label></div>
    <div><label> Password: <input type="password" name="password"/> </label></div>

    <input type="hidden" name="_csrf" value="{{_csrf.token}}" />
    <div><input type="submit" value="Sign In"/></div>
</form>
</#macro>