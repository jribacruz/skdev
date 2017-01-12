(function() {
	'use strict';

	angular.module('skdevMD').controller('ActionCT', ActionCT);

	ActionCT.$inject = [ '$scope', '$log' ];

	/**
	 * 
	 * @param $scope
	 * @param $log
	 * @returns
	 */
	function ActionCT($scope, $log) {
		$log.debug('[ActionCT] Inicializando...');
		var self = this;

		var editors = {};

		init();

		function init() {

		}
	}
})();
