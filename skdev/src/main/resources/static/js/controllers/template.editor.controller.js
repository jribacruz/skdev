(function() {
	'use strict';

	angular.module('skdevMD').controller('TemplateEditorCT', TemplateEditorCT);

	TemplateEditorCT.$inject = [ '$scope', '$log', '$mdDialog' ];

	/**
	 * 
	 * @param $scope
	 * @param $log
	 * @returns
	 */
	function TemplateEditorCT($scope, $log, $mdDialog) {
		$log.debug('[TemplateEditorCT] Inicializando...');
		var self = this;

		self.hide = hide;

		var templateEditor = {};

		init();

		function init() {

		}

		function hide() {
			console.log($scope)
			$mdDialog.hide();
		}
	}
})();
