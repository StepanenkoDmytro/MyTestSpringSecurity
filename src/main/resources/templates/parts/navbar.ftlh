<#include "security.ftlh">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="/api/v1">JustInterview</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link" href="/api/v1/chat">Chat</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/api/v1/blog">Blog</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/api/v1/question">Question</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/api/v1/admin">Admin</a>
      </li>
    </ul>
    <div class="navbar-text">${name}</div>
    <div class="navbar-text">${x}</div>
  </div>
</nav>