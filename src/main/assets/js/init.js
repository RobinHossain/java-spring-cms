

// ******************************************* Well Documented Javascript Coding *****************************/
var CRM = CRM || {};
$(function() {

var $window = $(window),
    $body = $('body'),
    $DataTable = $('#Dtable');
    $selectMaterial = $('select');
    $sideNav = $('.button-collapse');
    $dropDownButtonLeft = $('.dropdown-button.lft');
    $dropDownButtonRight = $('.dropdown-button.rht');
    $alertClose = $('#card-alert .close');
    $deletePopupClose = $('.cd-popup');
    $pageModal = $('.modal-trigger');



    CRM.global = {

        init: function() {
            // CRM.global.datatable();
            CRM.global.selectMatF();
            CRM.global.sideNavFun();
            CRM.global.leftDropDownMenu();
            CRM.global.rightDropDownMenu();
            CRM.global.closeAlert();
            CRM.global.deletePopupClose();
            CRM.global.initModalContent();
        },

        initModalContent: function () {
            if($pageModal.length > 0){
                $pageModal.each(function() {
                    var element = $(this);
                    element.leanModal({dismissible:!0,opacity:.5,in_duration:300,out_duration:200,ready:function(){},complete:function(){}})
                });
            }
        },

        deletePopupClose: function () {
            if($deletePopupClose.length > 0){
                $deletePopupClose.each(function() {
                    var element = $(this);
                    element.on('click', function(event){
                        if( $(event.target).is('.cd-popup-close') || $(event.target).is('.cd-popup') || $(event.target).is('.popUpClose') ) {
                            event.preventDefault();
                            $(this).removeClass('is-visible');
                        }
                    });
                });
            }
        },

        closeAlert: function () {
            if($alertClose.length > 0){
                $alertClose.each(function() {
                    var element = $(this);
                    element.click(function(){$(this).closest("#card-alert").fadeOut("slow")});
                });
            }
        },

        leftDropDownMenu: function () {
            if ($dropDownButtonLeft.length > 0) {
                $dropDownButtonLeft.each(function() {
                    var element = $(this);
                    element.dropdown({
                            inDuration: 300,
                            outDuration: 225,
                            hover: true, // Activate on hover
                            belowOrigin: true, // Displays dropdown below the button
                            alignment: 'left' // Displays dropdown with edge aligned to the left of button
                        }
                    );
                });
            }
        },

        rightDropDownMenu: function () {
            if ($dropDownButtonRight.length > 0) {
                $dropDownButtonRight.each(function() {
                    var element = $(this);
                    element.dropdown({
                            inDuration: 300,
                            outDuration: 225,
                            hover: true, // Activate on hover
                            belowOrigin: true, // Displays dropdown below the button
                            alignment: 'right' // Displays dropdown with edge aligned to the left of button
                        }
                    );
                });
            }
        },

        sideNavFun: function () {
            if ($sideNav.length > 0) {
                $sideNav.each(function() {
                    var element = $(this);
                    element.sideNav();
                });
            }
        },

        selectMatF: function () {
            if ($selectMaterial.length > 0) {
                $selectMaterial.each(function() {
                    var element = $(this);
                    element.material_select();
                });
            }
        },


        datatable: function() {
            if ($DataTable.length > 0) {
                $DataTable.each(function() {
                    var element = $(this);
                    element.DataTable({responsive:!0,dom:"Bfrtip",buttons:["copy","csv","excel","pdf","print"]});
                });
            }
        },


    };

    $(document).ready( CRM.global.init );

});
// ******************************************* # End # Well Documented Javascript Coding *****************************/