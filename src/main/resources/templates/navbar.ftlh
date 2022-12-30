<#include "style.ftlh">
<nav class="navbar" role="navigation" aria-label="main navigation" style="margin-bottom:1rem; border-bottom: 1px solid black">
    <div class="navbar-brand">
        <a class="navbar-item" href="http://localhost:8080/inventory/wine/index">
<#--            <img src="logo" width="112" height="28">-->
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
            <a class="navbar-item">
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
                <div class="buttons">
                    <a class="button is-primary">
                        <strong>Sign up</strong>
                    </a>
                    <a class="button is-light">
                        Log in
                    </a>
                </div>
            </div>
        </div>
    </div>
</nav>