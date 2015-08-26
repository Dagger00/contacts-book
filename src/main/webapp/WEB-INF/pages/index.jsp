<%--
  Created by IntelliJ IDEA.
  User: zenet_000
  Date: 8/24/2015
  Time: 3:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Contact Book</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/index.css" />"/>
</head>
<body>
<div class="page">
    <div class="page__button">
        <button class="button button_adduser"> Add user</button>
    </div>
    <div class="page__list">
        <jstl:forEach var="user" items="${list}">
            <div class="user">
                <div class="user__head">
                    <div class="head__name">
                        <jstl:out value="${user.firstName}"/> <jstl:out value="${user.lastName}"/>
                    </div>
                    <div class="head__button">
                        <button class="button button_add" data-id="${user.id}">
                            add
                        </button>
                        <button class="button button_deleteuser" data-id="${user.id}">
                            delete
                        </button>
                    </div>
                </div>
                <div class="user__contacts">
                    <jstl:forEach var="contact" items="${user.contacts}">
                        <div class="contact">
                            <div class="contact__body">
                                <div class="contact__type">
                                    <jstl:out value="${contact.type} : "/>
                                </div>
                                <div class="contact__value">
                                    <jstl:out value="${contact.value}"/>
                                </div>
                            </div>
                            <div class="contact__button">
                                <button class="button button_delete" data-id="${contact.id}">
                                    delete
                                </button>
                            </div>
                        </div>
                    </jstl:forEach>
                </div>
            </div>
        </jstl:forEach>
    </div>
</div>
<div class="overlay">

</div>
<div class="modal_user">
    <div class="modal__header">
        Add User
    </div>
    <div class="modal__fields">
        <form class="add_user">
            <div class="field">
                <input class="field__input" type="text" name="firstName" required/>

                <div class="field__label">First Name</div>
            </div>
            <div class="field">
                <input class="field__input" type="text" name="lastName" required/>

                <div class="field__label">Last Name</div>
            </div>
            <button class="button button_submituser" type="submit">
                submit
            </button>
        </form>
    </div>
</div>
<div class="modal_contact">
    <div class="modal__header">
        Add Contact
    </div>
    <div class="modal__fields">
        <form class="add_contact">
            <div class="field">
                <select id="dropdown" class="field__input" name="type">
                    <jstl:forEach var="type" items="${types}">
                        <option value="${type.type}">${type.value}</option>
                    </jstl:forEach>
                </select>
            </div>
            <div class="field">
                <input type="text" class="field__input" name="value" required/>

                <div class="field__label">Value</div>
            </div>
            <input type="text" class="userid" name="userid"/>
            <button class="button button_submitcontact" type="submit">
                submit
            </button>
        </form>
    </div>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/underscore.js/1.8.3/underscore-min.js"></script>
<script src="<c:url value="/resources/js/jquery.js"/>"></script>
<script src="<c:url value="/resources/js/main.js"/>"></script>
</body>
</html>
