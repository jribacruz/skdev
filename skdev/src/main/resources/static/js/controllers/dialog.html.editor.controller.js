(function() {
	'use strict';

	angular.module('skdevMD').controller('DialogHTMLEditorCT', DialogHTMLEditorCT);

	DialogHTMLEditorCT.$inject = [ '$scope', '$log', '$mdSidenav', '$mdDialog', 'notificationSV', 'dialogHTMLEditorSV' ];

	/**
	 * 
	 * @param $scope
	 * @param $log
	 * @param $mdSidenav
	 * @param $location
	 * @returns
	 */
	function DialogHTMLEditorCT($scope, $log, $mdSidenav, $mdDialog, notificationSV, dialogHTMLEditorSV) {
		$log.debug('[DialogHTMLEditorCT] Inicializando...');
		var self = this;

		init();

		function init() {
		}
		
		$scope.$on('action.editor.ready', function() {
			/*
			dialogHTMLEditorSV.getEditor().on('focus', function() {
				console.log('Editor DialogHTML em foco.')
			});
			*/
		});

	}
})();
