<#import "parts/common.ftlh" as c>
<#import "parts/registration.ftlh" as r>

<@c.page>
Registration
${message}
<@r.registration "/auth/registration" />

</@c.page>
