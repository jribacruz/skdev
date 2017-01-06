(function() {
	'use strict';

	angular.module('skdevMD').controller('ActionEditorCT', ActionEditorCT);

	ActionEditorCT.$inject = [ '$scope', '$log' ];

	/**
	 * 
	 * @param $scope
	 * @param $log
	 * @param ProjectSV
	 * @param $mdDialog
	 * @param $http
	 * @param HttpSV
	 * @returns
	 */
	function ActionEditorCT($scope, $log) {
		$log.debug('[ActionEditorCT] Inicializando...');
		var self = this;

		var editors = {};

		init();
		
		function init() {
			$log.debug('[ActionEditorCT] Inicializando editor execute.js')
			angular.element(document).ready(function() {
				//console.log(document.getElementById('executeEditor'))
				editors['execute'] = CodeMirror(document.getElementById('executeEditor'),{
					  value: "$notification.show('Funcionou')",
					  mode:  "javascript",
					  lineNumbers: true,
					  gutters: ["CodeMirror-lint-markers"],
					  lint: true,
					  autoCloseBrackets: true,
					  extraKeys: {"Ctrl-Space": "autocomplete"},
					  matchBrackets: false,
					  theme: 'eclipse',
					  indentUnit: 4
				});	
				editors['dialog'] = CodeMirror(document.getElementById('dialogEditor'),{
					  mode:  "htmlmixed",
					  lineNumbers: true,
					  autoCloseTags: true,
					  theme: 'eclipse'
					});
			});
		}
	}
})();
