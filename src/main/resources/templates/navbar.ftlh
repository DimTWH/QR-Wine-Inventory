<#include "style.ftlh">
<nav class="navbar" role="navigation" aria-label="main navigation" style="margin-bottom:1rem; border-bottom: 1px solid black">
    <div class="container">
        <div class="navbar-brand">
            <a class="navbar-item" href="http://localhost:8080/inventory/wine/index">
                <img src="/pictures/logo-h.png" width="90" height="50">
            </a>
            <a role="button" class="navbar-burger" aria-label="menu" aria-expanded="false" data-target="navbarBasicExample">
                <span aria-hidden="true"></span>
                <span aria-hidden="true"></span>
                <span aria-hidden="true"></span>
            </a>
        </div>
        <div id="navbarBasicExample" class="navbar-menu">
            <div class="navbar-start">
                <a class="navbar-item" href="http://localhost:8080/inventory/wine/index">
                    Inventory
                </a>
                <a class="navbar-item" href="http://localhost:8080/inventory/wine/new">
                    Add new
                </a>
                <a class="navbar-item" href="http://localhost:8080/user/profile">
                    Profile
                </a>
                <#--                        <div class="navbar-item has-dropdown is-hoverable">-->
                <#--                            <a class="navbar-link">-->
                <#--                                More-->
                <#--                            </a>-->
                <#--                            <div class="navbar-dropdown">-->
                <#--                                <a class="navbar-item">-->
                <#--                                    About-->
                <#--                                </a>-->
                <#--                                <a class="navbar-item">-->
                <#--                                    Jobs-->
                <#--                                </a>-->
                <#--                                <a class="navbar-item">-->
                <#--                                    Contact-->
                <#--                                </a>-->
                <#--                                <hr class="navbar-divider">-->
                <#--                                <a class="navbar-item">-->
                <#--                                    Report an issue-->
                <#--                                </a>-->
                <#--                            </div>-->
                <#--                        </div>-->
            </div>
            <div class="navbar-end">
                <div class="navbar-item">
    <#--                <input class="input" id="searchInputOnPageLoad" type="hidden" placeholder="Search anything..." name="search" value="${search}">-->
                    <form action="http://localhost:8080/inventory/wine/index" id="searchForm" style="display: inline-flex; position: relative;">
                        <div class="control">
                            <input class="input" id="searchInput" type="search" placeholder="Search anything..."
                                   name="search" value="<#if search != "">${search}<#else></#if>"/>
                        </div>
                        <div class="control">
                            <input class="button" type="submit" value="Search"/>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</nav>
<script>
    window.onload = () => {
        let previousSearchValue = document.getElementById("previousSearchValue");
        let searchInput = document.getElementById("searchInput");
            searchInput.focus();
            searchInput.setAttribute('value', previousSearchValue.value());
            searchInput.select();
            // searchInput.addEventListener('input', (c) => {
            //     searchInput.setAttribute("value", searchInput.value() + c);
            //     document.getElementById("searchForm").submit();
            // })
    }
</script>