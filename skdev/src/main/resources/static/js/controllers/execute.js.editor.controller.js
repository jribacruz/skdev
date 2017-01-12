(function() {
	'use strict';

	angular.module('skdevMD').controller('ExecuteJSEditorCT', ExecuteJSEditorCT);

	ExecuteJSEditorCT.$inject = [ '$scope', '$log', '$mdSidenav', '$mdDialog', 'notificationSV', 'executeJSEditorSV' ];

	/**
	 * 
	 * @param $scope
	 * @param $log
	 * @param $mdSidenav
	 * @param $location
	 * @returns
	 */
	function ExecuteJSEditorCT($scope, $log, $mdSidenav, $mdDialog, notificationSV, executeJSEditorSV) {
		$log.debug('[ExecuteJSEditorCT] Inicializando...');
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
