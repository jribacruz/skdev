(function() {
	'use strict';

	angular.module('skdevMD').controller('ActionCT', ActionCT);

	ActionCT.$inject = [ '$scope', '$log'];

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
	function ActionCT($scope, $log) {
		$log.debug('[ActionCT] Inicializando...');
		var self = this;

		var editors = {};
		
		$scope.value = "SkDev";
		
		$scope.templatesTreeData = [
			{id: "root", value: "Templates"}
		];

		init();

		function init() {
			$log.debug('[ActionCT] Inicializando editor execute.js')
			webix.ready(function() {

				/*
				 * Inicializando o editor de action execute
				 */
				editors['executejs'] = CodeMirror(document.getElementById('executejsEditor'), {
					mode : "javascript",
					lineNumbers : true,
					gutters : [ "CodeMirror-lint-markers" ],
					lint : true,
					autoCloseBrackets : true,
					extraKeys : {
						"Ctrl-Space" : "autocomplete"
					},
					matchBrackets : false,
					theme : 'eclipse',
					indentUnit : 4,
					styleActiveLine : true
				});
				editors['executejs'].setSize('100%', '100%');
				$$('templatesTree').attachEvent('onAfterSelect', function(id) {
					console.log(id)
				});
			});
		}
	}
})();
