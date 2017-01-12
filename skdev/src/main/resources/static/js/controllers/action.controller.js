(function() {
	'use strict';

	angular.module('skdevMD').controller('ActionCT', ActionCT);

	ActionCT.$inject = [ '$scope', '$log', '$mdDialog', 'eAction' ];

	/**
	 * 
	 * @param $scope
	 * @param $log
	 * @returns
	 */
	function ActionCT($scope, $log, $mdDialog, eAction) {
		$log.debug('[ActionCT] Inicializando...');
		var self = this;

		var editors = {};
		
		self.hide = hide;

		init();

		function init() {

		}
		
		function hide() {
			$mdDialog.hide();
		}
	}
})();
