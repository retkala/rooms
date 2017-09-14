'use strict';

angular.module('roomShares.controllers', ['toaster'])
    .controller('RoomController', ['$scope', '$scope', '$location', '$interval', 'toaster', function ($scope, $location, $interval, toaster) {

        $scope.username = '';
        $scope.stompClient = null;
        $scope.allRoomShares = [];
        $scope.rooms = [];
        $scope.shareStartDate = '';
        $scope.shareEndDate = '';
        $scope.sharedRooms = [];

        $scope.getRoomShares = function () {
            console.log("get room shares");
            $scope.stompClient.send("/app/roomshares", {}, {});
        };

        $scope.getUserRooms = function () {
            console.log("get user rooms");
            $scope.stompClient.send("/app/rooms", {}, JSON.stringify({'name': $scope.username}));
        };
        $scope.shareRoom = function (room) {
            console.log("SHARE: " + room + $scope.shareStartDate + $scope.shareEndDate);
            $scope.stompClient.send("/topic/rooms.share", {}, JSON.stringify({
                id: room.id,
                city: room.city,
                owner: room.owner
            }));
        };

        $scope.showGreeting = function () {
            $("#greetings").append("<tr><td>" + message + "</td></tr>");
        };

        var initStompClient = function () {
            var socket = new SockJS('/gs-guide-websocket');
            $scope.stompClient = Stomp.over(socket);
            $scope.stompClient.connect({}, function (frame) {
                console.log('Connected: ' + frame);
                $scope.username = frame.headers['user-name'];

                $scope.stompClient.subscribe('/user/queue/roomshares', function (data) {
                    $scope.allRoomShares = JSON.parse(data.body);
                    $scope.$apply();
                    console.log(data.body);

                });

                $scope.stompClient.subscribe('/user/queue/rooms', function (data) {
                    $scope.rooms = JSON.parse(data.body);
                    $scope.$apply();
                    console.log("USER ROOMS: ");
                    console.log(data.body);
                });

                $scope.stompClient.subscribe("/topic/rooms.share", function (data) {
                    console.log(data);
                    var room = JSON.parse(data.body);
                    $scope.sharedRooms.unshift(room);
                    $scope.$apply();
                });
            });
        };
        initStompClient();
    }]);