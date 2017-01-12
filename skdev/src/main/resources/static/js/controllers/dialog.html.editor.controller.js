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

	}
})();
