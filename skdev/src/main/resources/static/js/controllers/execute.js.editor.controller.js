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

	}
})();
